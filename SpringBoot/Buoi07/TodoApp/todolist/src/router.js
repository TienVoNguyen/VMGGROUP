import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      alias: "/todo-list",
      name: "todo-list",
      component: () => import("./components/TodoList")
    },
    {
      path: "/todo/:id",
      name: "todo-details",
      component: () => import("./components/Todo")
    },
    {
      path: "/add",
      name: "add",
      component: () => import("./components/AddTodo")
    }
  ]
});