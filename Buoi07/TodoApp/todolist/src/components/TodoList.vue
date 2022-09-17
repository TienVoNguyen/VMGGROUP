<template>
    <div class="list row">
      <div class="col-md-8">
        <div class="input-group mb-3">
          <input type="text" class="form-control" placeholder="Search by title"
            v-model="title"/>
          <div class="input-group-append">
            <button class="btn btn-outline-secondary" type="button"
              @click="searchTitle"
            >
              Search
            </button>
          </div>
        </div>
      </div>
      <div class="col-md-6">
        <h4>Todo List</h4>
        <ul class="list-group">
          <li class="list-group-item"
            :class="{ active: index == currentIndex }"
            v-for="(todo, index) in todoList"
            :key="index"
            @click="setActiveTodo(todo, index)"
          >
            {{ todo.title }}
          </li>
        </ul>

        <button class="m-3 btn btn-sm btn-danger" @click="removeAllTodoList">
          Remove All
        </button>
      </div>
      <div class="col-md-6">
        <div v-if="currentTodo">
          <h4>Todo</h4>
          <div>
            <label><strong>Title:</strong></label> {{ currentTodo.title }}
          </div>
          <div>
            <label><strong>Description:</strong></label> {{ currentTodo.description }}
          </div>
          <div>
            <label><strong>Status:</strong></label> {{ currentTodo.todoStatus }}
          </div>
          <div>
            <label><strong>Date Created:</strong></label> {{ currentTodo.dateCreated}}
          </div>
          <div>
            <label><strong>Last Modified:</strong></label> {{ currentTodo.lastModified }}
          </div>
          <a class="badge badge-warning"
            :href="'/todo/' + currentTodo.id"
          >
            Edit
          </a>
        </div>
        <div v-else>
          <br />
          <p>Please click on a Todo...</p>
        </div>
      </div>
    </div>
  </template>

  <script>
  import TodoDataService from "../service/TodoDataService";

  export default {
    name: "todo-list",
    data() {
      return {
        todoList: [],
        currentTodo: null,
        currentIndex: -1,
        title: ""
      };
    },
    methods: {
      retrieveTodoList() {
        TodoDataService.getAll()
          .then(response => {
            this.todoList = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
      },

      refreshList() {
        this.retrieveTodoList();
        this.currentTodo = null;
        this.currentIndex = -1;
      },

      setActiveTodo(todo, index) {
        this.currentTodo = todo;
        this.currentIndex = index;
      },

      removeAllTodoList() {
        TodoDataService.deleteAll()
          .then(response => {
            console.log(response.data);
            this.refreshList();
          })
          .catch(e => {
            console.log(e);
          });
      },

      searchTitle() {
        TodoDataService.findByTitle(this.title)
          .then(response => {
            this.todoList = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
      }
    },
    mounted() {
      this.retrieveTodoList();
    }
  };
  </script>

  <style>
  .list {
    text-align: left;
    max-width: 750px;
    margin: auto;
  }
  </style>