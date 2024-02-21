<template>

    <v-card outlined>
        <v-card-title>
            MyRequest # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="UserId" v-model="item.userId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ModelName" v-model="item.modelName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="State" v-model="item.state" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'MyRequestViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/myRequests/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

