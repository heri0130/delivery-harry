<template>

    <v-data-table
        :headers="headers"
        :items="selectDeliveryInfo"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'SelectDeliveryInfoView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            selectDeliveryInfo : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/selectDeliveryInfos'))

            temp.data._embedded.selectDeliveryInfos.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.selectDeliveryInfo = temp.data._embedded.selectDeliveryInfos;
        },
        methods: {
        }
    }
</script>

