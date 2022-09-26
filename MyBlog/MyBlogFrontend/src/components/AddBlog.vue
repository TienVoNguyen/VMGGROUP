<template>
  <el-form :model="blog" id="form-blog" :rules="rules" ref="blog" label-width="120px" class="demo-blog">
    <el-form-item label="Blog title" prop="title">
      <el-input name="title" v-model="blog.title"></el-input>
    </el-form-item>
    <el-form-item label="Category" prop="category">
      <el-select name="categoryCode" v-model="blog.categoryCode" placeholder="Category">
        <el-option label="Zone one" value="shanghai"></el-option>
        <el-option label="Zone two" value="beijing"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="Content" prop="content">
      <el-input name="content" type="textarea" v-model="blog.content"></el-input>
    </el-form-item>
    <el-form-item label="Blog covers" prop="cover">
      <input multiple type="file" name="cover">
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('blog')">Create</el-button>
      <el-button @click="resetForm('blog')">Reset</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import BlogDataService from "@/service/BlogDataService";
export default {
  name: "AddBlog",
  data() {
    return {
      blog: {
        title: '',
        categoryCode: 'pc',
        content: '',
        cover: []
      },
      rules: {
        title: [
          { required: true, message: 'Please input title blog', trigger: 'blur' },
          { min: 3, max: 20, message: 'Length should be 3 to 20', trigger: 'blur' }
        ],
        categoryCode: [
          { required: true, message: 'Please select Category ', trigger: 'change' }
        ],
        content: [
          { required: true, message: 'Please input content bolg', trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
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
  }
}
</script>

<style scoped>

</style>