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
 *
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

/**
 * 刷新规则文件（物理）
 *
 * @param params
 * @returns {AxiosPromise}
 */
export function loadRule(params) {
  return request({
    url: '/ruleLoadAndUse/loadRule',
    method: 'post',
    data: params
  })
}

/**
 * 规则删除
 * @returns {AxiosPromise}id
 * @param id
 */
export function deleteRuleById(id) {
  return request({
    url: '/ruleLoadAndUse/deleteRuleById',
    method: 'get',
    params: { id: id }
  })
}
