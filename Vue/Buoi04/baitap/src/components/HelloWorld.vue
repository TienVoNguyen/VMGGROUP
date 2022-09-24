<template>
  <div id='parent'>
    <h1 style="color: green;">
      {{msg}}
    </h1>
    <h3>Two Way Data Binding</h3>

    <p><Strong>{{text}}</Strong></p>

    <input type="text" v-model="text">
    <br><br>
    <strong>Sex : </strong>
    <input type="radio" id="m" value="male"
           v-model="sex">
    <label for="male">Male</label>
    <input type="radio" id="f" value="female"
           v-model="sex">
    <label for="female">Female</label>
    <input type="radio" id="b" value="bi-sexual"
           v-model="sex">
    <label for="bi-sexual">Bisexual</label>


    <p><strong>Your Sex: </strong>{{ sex }}</p>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  data() {
    return {
      text: 'Hi, I\'m Nguyen Tien Vo',
      sex: 'male'
    }
  }
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
