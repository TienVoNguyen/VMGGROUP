<template>
  <el-form :model="blog" id="form-blog" :rules="rules" ref="blog" label-width="120px" class="demo-blog">
    <el-form-item label="Blog title" prop="title">
      <el-input name="title" v-model.trim="blog.title"></el-input>
    </el-form-item>
    <el-form-item label="Category" prop="categoryCode">
      <b-form-select :state="Boolean(blog.categoryCode)" name="categoryCode" v-model="blog.categoryCode" class="mb-3">
        <template #first>
          <b-form-select-option value="" disabled>-- Please select an option --</b-form-select-option>
        </template>
        <b-form-select-option v-for="cate in categories" :key="cate.id" :value="cate.code">{{ cate.name }}
        </b-form-select-option>
      </b-form-select>
    </el-form-item>
    <el-form-item label="Content" prop="content">
      <el-input name="content" type="textarea" v-model.trim="blog.content"></el-input>
    </el-form-item>
    <el-form-item label="Blog covers" prop="cover">
      <b-form-file
          v-model="blog.cover"
          name="cover" multiple accept="image/*"
          placeholder="Choose your images..."
          >
        <template #file-name="{ names }">
          <b-badge variant="dark">{{ names[0] }}</b-badge>
          <b-badge v-if="names.length > 1" variant="dark" class="ml-1">
            + {{ names.length - 1 }} More images
          </b-badge>
        </template>
      </b-form-file>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('blog')">Create</el-button>
      <el-button @click="resetForm('blog')">Reset</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import BlogDataService from "@/service/BlogDataService";
import CategoryDataService from "@/service/CategoryDataService";

export default {
  name: "AddBlog",
  data() {
    return {
      blog: {
        title: '',
        categoryCode: '',
        content: '',
        cover: []
      },
      categories: [],
      rules: {
        title: [
          {required: true, message: 'Please input title blog', trigger: 'blur'},
          {min: 3, max: 20, message: 'Length should be 3 to 20', trigger: 'blur'}
        ],
        categoryCode: [
          {required: true, message: 'Please select Category ', trigger: 'change'}
        ],
        content: [
          {required: true, message: 'Please input content bolg', trigger: 'blur'}
        ],
        cover: [
          {required: true, message: 'Please input cover bolg', trigger: 'change'}
        ]
      }
    };
  },
  methods: {
    test() {
      console.log(this.blog.categoryCode)
    },
    vali(formName) {
      this.$refs[formName].validate((valid) => {
        console.log(valid)
      })
    },

    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          let form = document.querySelector('#form-blog');
          console.log(form);
          BlogDataService.create(form);
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },
  created() {
    CategoryDataService.getAll()
        .then(response => {
          this.categories = response.data
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
  }
}
</script>

<style scoped>

</style>