- 总操作
1. 在初始化数据库中，删除逻辑删除的标识@TableLogic
- 用户
1.保证admin的ID是1
- 公司
1.更新的是客商表bdm_customer 和 t_customer
2.根据公司code初始化，为了保证code唯一，重复code删除状态的增加YXGS，正常状态的增加YX
- 部门
1. 商贸：将鑫抚源下面部门的comp_id改成000001