import Vue from 'vue'
import Router from 'vue-router'

import main from '@/views/Main'
import notfound from '@/views/NotFound'

import home from '../components/views/home/Index'
import overview from '../components/views/overview/Index'
import motif from '../components/views/motif/Index'
import browse from '../components/views/browse/Index'
import annotation from '../components/views/annotation/Index'
import upload from '../components/views/annotation/views/Upload'
import plot from '../components/views/annotation/components/Plot'
import help from '../components/views/help/Index'

const originalPush = Router.prototype.push
Router.prototype.push = function push (location, onResolve, onReject) {
  if (onResolve || onReject){
    return originalPush.call(this, location, onResolve, onReject)
  }
  return originalPush.call(this, location).catch(err => err)
}


Vue.use(Router)

export default new Router({
    mode:'history',
    routes: [
        { 
            path: '/',
            redirect: '/home',
            component: main,
            children: [
                { 
                    path: '/home',
                    component: home
                },
                { 
                    path: '/help',
                    component: help
                },
                { 
                    path: '/browse',
                    component: browse
                },
                { 
                    path: '/annotation',
                    component: annotation,
                },
            ]
        },
        { path: '*', component: notfound }
        
    ]
})