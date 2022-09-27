<template>
  <el-container>
    <el-main>
      <el-table
          :data="blogList"
          border
          style="width: 100%">
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
            prop="categoryCode"
            label="Category Code">
        </el-table-column>
        <el-table-column
            label="Cover">
          <template v-slot="scope">
            <img width="50px" v-for="(cover, index) in scope.row.coverNameList" :key="index"
                 v-bind:src="'http://localhost:1997/api/files/images?file='+cover" alt="anh">
          </template>
        </el-table-column>
      </el-table>
    </el-main>
    <el-footer>
      <el-pagination
          background
          layout="prev, pager, next"
          :total="total"
          :page-count="totalPages"
          :current-page="currentIndex"
          :page-size="blogList.length">
      </el-pagination>
    </el-footer>
  </el-container>
</template>

<script>
import BlogDataService from "@/service/BlogDataService";

export default {
  name: "BlogListComponent",
  data() {
    return {
      blogList: [],
      currentBlog: null,
      currentIndex: -1,
      title: "",
      total: 5,
      totalPages: 3,
    }
  },
  methods: {
    retrieveBlogList() {
      BlogDataService.getAll()
          .then(response => {
            this.blogList = response.data.blogDTOList;
            this.total = response.data.totalItems;
            this.totalPages = response.data.totalPages;
            this.currentIndex = response.data.currentPage + 1;
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

    removeAllBlogList() {
      BlogDataService.deleteAll()
          .then(response => {
            console.log(response.data);
            this.refreshList();
          })
          .catch(e => {
            console.log(e);
          });
    },

    searchTitle() {
      BlogDataService.findByTitle(this.title)
          .then(response => {
            this.blogList = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    }
  },
  mounted() {
    this.retrieveBlogList();
  }
}
</script>