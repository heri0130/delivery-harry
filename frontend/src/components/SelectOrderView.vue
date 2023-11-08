<template>

    <v-data-table
        :headers="headers"
        :items="selectOrder"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'SelectOrderView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            selectOrder : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/selectOrders'))

            temp.data._embedded.selectOrders.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.selectOrder = temp.data._embedded.selectOrders;
        },
        methods: {
        }
    }
</script>

