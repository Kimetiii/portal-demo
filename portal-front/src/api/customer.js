import request from '@/utils/request'

export function findAll(params) {
  return request({
    url: '/customerBase/findAllCustomer',
    method: 'get',
    data: params
  })
}
export function findAllCustomerByDeleteStatus(params) {
  return request({
    url: '/customerBase/findAllCustomerByDeleteStatus',
    method: 'get',
    data: params
  })
}


export function addCustomer(params) {
  return request({
    url: '/customerBase/addCustomer',
    method: 'post',
    data: params
  })
}

export function getCustomerById(params) {
  return request({
    url: '/customerBase/getCustomerById?id='+params,
    method: 'post'
  })
}

export function searchCustomerList(params) {
  return request({
    url: '/customerBase/searchCustomerList',
    method: 'post',
    data: params
  })
}

export function softDeleteById(params) {
  return request({
    url: '/customerBase/softDeleteById?id='+params,
    method: 'post'
  })
}



