<template>

    <v-data-table
        :headers="headers"
        :items="selectOrderInfo"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'SelectOrderInfoView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "menuName", value: "menuName" },
                { text: "menuQty", value: "menuQty" },
                { text: "amount", value: "amount" },
                { text: "orderId", value: "orderId" },
                { text: "payId", value: "payId" },
                { text: "orderStatus", value: "orderStatus" },
                { text: "payStatus", value: "payStatus" },
                { text: "userId", value: "userId" },
            ],
            selectOrderInfo : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/selectOrderInfos'))

            temp.data._embedded.selectOrderInfos.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.selectOrderInfo = temp.data._embedded.selectOrderInfos;
        },
        methods: {
        }
    }
</script>

