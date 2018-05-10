<template>
</template>

<script>
export default {
  name: 'Authority',
  data: function() {
    return {
      authEndpoint: 'http://localhost:8080/oauth/authorize',
      clientId: 'cli',
      accessToken: '',
    }
  },
  methods: {
    makeAccessToken: function(redirectUri) {
      this.$http.get(this.authEndpoint, {
        params: {
          response_type: 'token',
          client_id: this.clientId,
          redirect_uri: redirectUri,
          scope: 'read'
        }
      })
        .then((res) => {
          console.log(res);
        })
        .catch((err) => {
          console.log(err);
        });
    }
  }
}
</script>
