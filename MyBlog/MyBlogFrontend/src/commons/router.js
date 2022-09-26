import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
    mode: "history",
    routes: [
        {
            path: "/",
            alias: "/blog-list",
            name: "blog-list",
            component: () => import("../components/BlogListComponent")
        },
        {
            path: "/todo/:id",
            name: "todo-details",
            component: () => import("../components/BlogComponent")
        },
        {
            path: "/add",
            name: "add",
            component: () => import("../components/AddBlog")
        }
    ]
});