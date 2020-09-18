import request from '@/utils/request'

export function findAll(params) {
  return request({
    url: '/customerBase/findAllCustomer',
    method: 'get',
    data: params
  })
}

export function addCostomer(params) {
  return request({
    url: '/customerBase/addCustomer',
    method: 'post',
    data: params
  })
}


