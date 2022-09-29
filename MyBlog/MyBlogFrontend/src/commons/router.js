import Vue from "vue";
import Router from "vue-router";
import Login from "@/components/User/Login";
import Register from "@/components/User/Register";

Vue.use(Router);

const router = new Router({
    mode: "history",
    routes: [
        {
            path: '/login',
            component: Login
        },
        {
            path: '/register',
            component: Register
        },
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
router.beforeEach((to, from, next) => {
    const publicPages = ['/login', '/register', '/home'];
    const authRequired = !publicPages.includes(to.path);
    const loggedIn = localStorage.getItem('user');

    // trying to access a restricted page + not logged in
    // redirect to login page
    if (authRequired && !loggedIn) {
        next('/login');
    } else {
        next();
    }
});
export default router
