import request from '@/utils/request'

export function page(params) {
  return request({
    url: '/ledger/page',
    method: 'post',
    data: params
  })
}

export function create(params) {
  return request({
    url: '/ledger/create',
    method: 'post',
    data: params
  })
}

export function create4SameGroup(params) {
  return request({
    url: '/ledger/create4SameGroup',
    method: 'post',
    data: params
  })
}

export function edit(params) {
  return request({
    url: '/ledger/edit',
    method: 'post',
    data: params
  })
}

export function upload(params) {
  return request({
    url: 'ledger/upload',
    method: 'post',
    data: params
  }, {
    headers: { 'Content-Type': 'multipart/form-data' }
  })
}

export function deleteOne(id) {
  return request({
    url: '/ledger/delete',
    method: 'get',
    params: { id: id }
  })
}

export function deleteSelect(params) {
  return request({
    url: '/ledger/deleteSelect',
    method: 'post',
    data: params
  })
}

export function download(id) {
  return request({
    url: '/ledger/download',
    method: 'get',
    withCredentials: false,
    responseType: 'blob',
    params: { id: id }
  })
}

export function downloadSelect(params) {
  return request({
    url: '/ledger/downloadSelect',
    method: 'post',
    withCredentials: false,
    responseType: 'blob',
    data: params
  })
}

export function getLedgersByGroupId(id) {
  return request({
    url: '/ledger/getLedgersByGroupId',
    method: 'get',
    params: { groupId: id }
  })
}

export function bindingGroupIds(ids) {
  return request({
    url: '/ledger/bindingGroupIds',
    method: 'post',
    data: ids
  })
}

export function unbindingGroupId(id) {
  return request({
    url: '/ledger/unbindingGroupId',
    method: 'get',
    params: { id: id }
  })
}
