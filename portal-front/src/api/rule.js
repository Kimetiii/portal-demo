import request from '@/utils/request'

/**
 * 查询规则
 *
 * @param params
 * @returns {AxiosPromise}
 */
export function getRules(params) {
  return request({
    url: '/ruleLoadAndUse/getAllRules',
    method: 'get',
    data: params
  })
}

/**
 * 新增/修改 规则
 * @param params
 * @returns {AxiosPromise}
 */
export function addRule(params) {
  return request({
    url: '/ruleLoadAndUse/addRule',
    method: 'post',
    data: params
  })
}
