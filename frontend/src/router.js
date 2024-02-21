
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ModelModelManager from "./components/listers/ModelModelCards"
import ModelModelDetail from "./components/listers/ModelModelDetail"

import NoticeNoticeManager from "./components/listers/NoticeNoticeCards"
import NoticeNoticeDetail from "./components/listers/NoticeNoticeDetail"

import CoreCoreManager from "./components/listers/CoreCoreCards"
import CoreCoreDetail from "./components/listers/CoreCoreDetail"

import TargetTargetManager from "./components/listers/TargetTargetCards"
import TargetTargetDetail from "./components/listers/TargetTargetDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/models/models',
                name: 'ModelModelManager',
                component: ModelModelManager
            },
            {
                path: '/models/models/:id',
                name: 'ModelModelDetail',
                component: ModelModelDetail
            },

            {
                path: '/notices/notices',
                name: 'NoticeNoticeManager',
                component: NoticeNoticeManager
            },
            {
                path: '/notices/notices/:id',
                name: 'NoticeNoticeDetail',
                component: NoticeNoticeDetail
            },

            {
                path: '/cores/cores',
                name: 'CoreCoreManager',
                component: CoreCoreManager
            },
            {
                path: '/cores/cores/:id',
                name: 'CoreCoreDetail',
                component: CoreCoreDetail
            },

            {
                path: '/targets/targets',
                name: 'TargetTargetManager',
                component: TargetTargetManager
            },
            {
                path: '/targets/targets/:id',
                name: 'TargetTargetDetail',
                component: TargetTargetDetail
            },



    ]
})
