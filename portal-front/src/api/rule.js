import request from '@/utils/request'

// 这里是一个伪接口 需要查询规则
export function getRules(params) {
  return request({
    url: '/dut/rule',
    method: 'post',
    data: params
  })
}

