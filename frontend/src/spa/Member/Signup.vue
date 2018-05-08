<template>
  <div id="signup">
    <div class="row">
      <div class="input-field col s12">
        <input id="uid" v-model="form.uid" type="text"/>
        <label for="uid">Username</label>
      </div>
    </div>
    <div class="row">
      <div class="input-field col s12">
        <input id="name" v-model="form.name" type="text"/>
        <label for="name">Name</label>
      </div>
    </div>
    <div class="row">
      <div class="input-field col s12">
        <input id="email" v-model="form.email" type="email"/>
        <label for="email">Email</label>
      </div>
    </div>
    <div class="row">
      <div class="input-field col s12">
        <input id="password" v-model="form.password" type="password"/>
        <label for="password">Password</label>
      </div>
    </div>
    <input type="button" value="가입하기" @click="submit" />
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: {
        uid: '',
	name: '',
	password: '',
	email: '',
      },
      errors: []
    }
  },
  methods: {
    validForm() {
      if(!this.form.uid) {
        this.errors.push({field:'uid', message: '아이디를 입력하세요'});
      }
      if(!this.form.name) {
        this.errors.push({field:'name', message: '이름을 입력하세요'});
      }
      if(!this.form.password) {
        this.errors.push({field:'password', message: '비밀번호를 입력하세요'});
      }
      if(!this.form.email) {
        this.errors.push({field:'email', message: '이메일을 입력하세요'});
      }

      return this.errors.length;
    },
    submit() {
      this.errors = [];
      if(this.validForm() > 0)
        return;

      const joinURI = '/members/'+this.form.uid;
      this.$http.post(joinURI, this.form)
        .then(res => {
          if(res.status == 200) {
            alert("회원가입 완료");
	    window.location.href="/";
          } else {
            console.log(res.data);
          }
        })
        .catch(err => {
          if(err.response) {
            this.errors = err.response.data.data;
          } else {
            this.errors.push({field:'', message: 'csrf header 없음'});
          }
        })
        ;
    }
  }
}
</script>

<style>
</style>
