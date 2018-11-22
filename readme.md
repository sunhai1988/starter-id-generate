###分#布式订单编号生成

maven { url "" }

compile group: 'top.quany',name: 'starter-id-generate',version: '1.0.0'

配置生成服务器ID

id:
  generate:
    machine: 191
 
 在需要使用id生成的controller中
 
  @Autowired
  IdService idService;
  
  1.生成
  long orderNo = idService.genId(); ---->30204396163825855
  2.反解
  idService.expId(orderNo) 
    解析内容：
    [machine=191,seq=0,time=28130036,genMethod=0,type=0,version=0]
  
