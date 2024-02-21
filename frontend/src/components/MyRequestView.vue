<template>

    <v-data-table
        :headers="headers"
        :items="myRequest"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'MyRequestView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "userId", value: "userId" },
                { text: "modelName", value: "modelName" },
                { text: "state", value: "state" },
            ],
            myRequest : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/myRequests'))

            temp.data._embedded.myRequests.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.myRequest = temp.data._embedded.myRequests;
        },
        methods: {
        }
    }
</script>

