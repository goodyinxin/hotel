<template>
  <div class="hello">
    <form class="form-signin"  action="dashboard.html" method="post">

      <img class="mb-4" src="/asserts/img/bootstrap-solid.svg" alt="" width="300" height="172"/>
      <h2 class="h3 mb-3 font-weight-normal">登录</h2>
      <!--<p th:text="${msg}" style="color: red" th:if="${not #strings.isEmpty(msg)}"></p>-->

      <!--警告框-->
      <div class="position-sticky" >
        <p id="myAlert" class="alert alert-warning alert-dismissible fade show" role="alert" >
          <strong  >Holy guacamole!</strong>
          <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </p>
      </div>
      <!--警告框-->

      <label class="sr-only">用户名</label>
      <input name="username" type="text" class="form-control" placeholder="Username" required="" autofocus="">
      <br/>
      <label class="sr-only">密码</label>
      <input name="password" type="password" class="form-control" placeholder="Password" required="">
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> 记住我
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      <p class="mt-5 mb-3 text-muted">© 2019-2020</p>
      <!--<a class="btn btn-sm">中文</a>
      <a class="btn btn-sm">English</a>-->
    </form>


  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
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
