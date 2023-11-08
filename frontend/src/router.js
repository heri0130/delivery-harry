
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderOrderMgmtManager from "./components/listers/OrderOrderMgmtCards"
import OrderOrderMgmtDetail from "./components/listers/OrderOrderMgmtDetail"

import PaymentPaymentMgmtManager from "./components/listers/PaymentPaymentMgmtCards"
import PaymentPaymentMgmtDetail from "./components/listers/PaymentPaymentMgmtDetail"

import StoreOrderStoreOrderMgmtManager from "./components/listers/StoreOrderStoreOrderMgmtCards"
import StoreOrderStoreOrderMgmtDetail from "./components/listers/StoreOrderStoreOrderMgmtDetail"

import DeliveryDeliveryMgmtManager from "./components/listers/DeliveryDeliveryMgmtCards"
import DeliveryDeliveryMgmtDetail from "./components/listers/DeliveryDeliveryMgmtDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders/orderMgmts',
                name: 'OrderOrderMgmtManager',
                component: OrderOrderMgmtManager
            },
            {
                path: '/orders/orderMgmts/:id',
                name: 'OrderOrderMgmtDetail',
                component: OrderOrderMgmtDetail
            },

            {
                path: '/payments/paymentMgmts',
                name: 'PaymentPaymentMgmtManager',
                component: PaymentPaymentMgmtManager
            },
            {
                path: '/payments/paymentMgmts/:id',
                name: 'PaymentPaymentMgmtDetail',
                component: PaymentPaymentMgmtDetail
            },

            {
                path: '/storeOrders/storeOrderMgmts',
                name: 'StoreOrderStoreOrderMgmtManager',
                component: StoreOrderStoreOrderMgmtManager
            },
            {
                path: '/storeOrders/storeOrderMgmts/:id',
                name: 'StoreOrderStoreOrderMgmtDetail',
                component: StoreOrderStoreOrderMgmtDetail
            },

            {
                path: '/deliveries/deliveryMgmts',
                name: 'DeliveryDeliveryMgmtManager',
                component: DeliveryDeliveryMgmtManager
            },
            {
                path: '/deliveries/deliveryMgmts/:id',
                name: 'DeliveryDeliveryMgmtDetail',
                component: DeliveryDeliveryMgmtDetail
            },



    ]
})
