import request from '@/utils/request'

export function pagePeople(params) {
  return request({
    url: '/people/pagePeople',
    method: 'get',
    params: params
  })
}
