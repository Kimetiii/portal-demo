import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/process',
    method: 'post',
    data
  })
}

export function getInfo() {
  return request({
    url: '/sys/getAccountInfo',
    method: 'get'
  })
}

export function logout() {
  return request({
    url: '/logout',
    method: 'post'
  })
}
