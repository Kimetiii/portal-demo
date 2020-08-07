import Vue from 'vue'
import Vuex from 'vuex'
import getters from './getters'
import app from './modules/app'
import settings from './modules/settings'
import user from './modules/user'

Vue.use(Vuex)

// 初始化
const store = new Vuex.Store({
  modules: {
    app,
    settings,
    user
  },
  getters
})

export default store
