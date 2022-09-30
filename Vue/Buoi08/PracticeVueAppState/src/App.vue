<template>
  <div id="app">
    <div class="container-fluid col-centered todo-app">
      <center><h1><strong>todos</strong></h1></center>
      <input class="form-control" v-model="newTodo" v-on:keyup.enter="addTodo(newTodo)">
      <h3><span><i>uncompleted </i>({{ remaining.length }})</span></h3>
      <ul class="list-group">
        <li class="list-group-item list-group-item-info" v-for="(todo, index) in remaining" :key="index">
          <span>{{ todo.content }}</span>
          <button class="btn btn-danger" @click="deleteTodo(todo)">
            Delete
          </button>
          <button class="btn btn-info" @click="toggleStatus(todo)">
            Completed
          </button>
        </li>
      </ul>
      <p>Start hacking and add some tasks!</p>
      <div v-if="completed.length">
        <h3><i>completed</i> ({{ completed.length }})</h3>
        <ul class="list-group">
          <li class="list-group-item list-group-item-success" v-for="(todo, index) in completed" :key="index">
            {{ todo.content }}
            <button class="btn btn-secondary" @click="toggleStatus(todo)">
              UnCompleted
            </button>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>
<script>
import { mapGetters, mapActions } from 'vuex';

export default {
  name: 'app',
  data() {
    return {
      newTodo : ''
    }
  },
  computed: mapGetters(['remaining', 'completed']),
  methods: mapActions(['addTodo','toggleStatus','deleteTodo'])
}
</script>