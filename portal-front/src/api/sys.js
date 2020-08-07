import request from '@/utils/request'

export function page(params) {
  return request({
    url: '/sys/pageAccount',
    method: 'post',
    data: params
  })

}
