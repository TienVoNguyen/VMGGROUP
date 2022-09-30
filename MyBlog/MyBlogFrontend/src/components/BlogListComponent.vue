<template>
  <el-container>
    <el-header>
      <el-select v-model="categoryCode" @change="findByCategoryCode()" placeholder="Select Category">
        <el-option value="" label="Select Category"></el-option>
        <el-option
            v-for="item in categories"
            :key="item.id"
            :label="item.name"
            :value="item.code">
        </el-option>
      </el-select>
    </el-header>
    <el-main>
      <el-table
          ref="multipleTable"
          :data="this.categoryCode.length<=0?blogList.filter(data => !search || data.title.toLowerCase().includes(search.toLowerCase())):this.blogListCode"
          @selection-change="handleSelectionChange"
          border
          style="width: 100%">
        <el-table-column
            type="selection"
            width="55">
        </el-table-column>
        <el-table-column
            prop="title"
            label="Title"
            width="180">
        </el-table-column>
        <el-table-column
            prop="content"
            label="Content"
            width="180">
        </el-table-column>
        <el-table-column
            label="Category Code">
          <template v-slot="scope">
            <div v-for="cate in categories" :key="cate.id">
              <span v-show="scope.row.categoryCode === cate.code">
                {{ cate.name }}
              </span>
            </div>
          </template>
        </el-table-column>
        <el-table-column
            label="Cover">
          <template v-slot="scope">
            <img height="50px" v-for="(cover, index) in scope.row.coverNameList" :key="index"
                 :src="'http://localhost:1997/api/files/images?file=' + cover" alt="anh">
          </template>
        </el-table-column>
        <el-table-column
            align="right">
          <template #header>
            <div class="header">
              <el-input
                  v-model="search"
                  size="medium"
                  placeholder="Type to search"/>
            </div>
          </template>
          <template v-slot="scope">
            <el-button
                size="mini"
                @click="handleEdit(scope.$index, scope.row)">Edit
            </el-button>
            <el-button
                size="mini"
                type="danger"
                @click="handleDelete(scope.$index, scope.row)">Delete
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <div style="margin-top: 20px">
        <el-button type="danger" @click="removeBlogList">Delete</el-button>
        <el-button @click="clearSelection">Clear selection</el-button>
      </div>
    </el-main>
    <el-footer>
      <el-pagination
          background
          layout="prev, pager, next"
          :total="itemCount"
          :page-count="count"
          :page-size="pageSize"
          :page-sizes="pageSizes"
          @current-change="handlePageChange"
          hide-on-single-page>
      </el-pagination>
    </el-footer>
  </el-container>
</template>

<script>
import BlogDataService from "@/service/BlogDataService";
import CategoryDataService from "@/service/CategoryDataService";

export default {
  name: "BlogListComponent",
  data() {
    return {
      blogList: [],
      blogListCode: [],
      categories: [],
      currentBlog: null,
      currentIndex: -1,
      page: 1,
      count: 0,
      pageSize: 2,
      itemCount: 6,
      pageSizes: [2, 4, 6],
      multipleSelection: [],
      search: '',
      categoryCode: ''
    }
  },
  methods: {
    retrieveBlogList() {
      const params = this.getRequestParams(
          this.page,
          this.pageSize
      );
      console.log(params)
      // let data = JSON.stringify(params)
      BlogDataService.getAll(params)
          .then(response => {
            this.blogList = response.data.blogDTOList;
            this.count = response.data.totalPages;
            this.itemCount = response.data.totalItems;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    },

    refreshList() {
      this.retrieveBlogList();
      this.currentBlog = null;
      this.currentIndex = -1;
    },

    setActiveBlog(blog, index) {
      this.currentBlog = blog;
      this.currentIndex = index;
    },

    removeBlogList() {
      BlogDataService.delete(this.multipleSelection)
          .then(response => {
            console.log(response.data);
            this.refreshList();
          })
          .catch(e => {
            console.log(e);
          });
    },

    getRequestParams(page, pageSize) {
      let params = {};

      // if (searchTitle) {
      //   params["title"] = searchTitle;
      // }

      if (page) {
        params["page"] = page - 1;
      }

      if (pageSize) {
        params["size"] = pageSize;
      }

      return params;
    },

    // searchTitle() {
    //   BlogDataService.findByTitle(this.title)
    //       .then(response => {
    //         this.blogList = response.data;
    //         console.log(response.data);
    //       })
    //       .catch(e => {
    //         console.log(e);
    //       });
    // },
    findByCategoryCode() {
      console.log(this.categoryCode)
      this.blogListCode = this.blogList.filter((blog) => {
        return this.categoryCode === blog.categoryCode
      })
    },

    handleEdit(index, row) {
      console.log(index, row);
    },
    handleDelete(index, row) {
      console.log(index, row);
    },

    handlePageChange(value) {
      this.page = value;
      console.log(this.page)
      this.retrieveBlogList();
    },

    handleSelectionChange(val) {
      let ids = [];
      val.forEach(v => {
        ids.push(v.id);
      })
      this.multipleSelection = [...ids];
      console.log(ids)
      console.log(this.multipleSelection)
    },

    clearSelection() {
      this.$refs.multipleTable.clearSelection();
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
  },

  mounted() {
    this.retrieveBlogList();
  }
}
</script>