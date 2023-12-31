# JDBC综合案例-商品销售管理系统控制台版

**1.项目说明**：传统的商品管理一直依靠手工的方式，不能及时向经营者提供各类商品库存信息，从一定程度上影响了企业的经营活动，为此建立了一套动态反应商品信息的管理系统。该商品管理系统主要体现两点特性：(1).提高经营者管理水平，为企业提供有力的决策支持。(2)对商品信息进行科学化管理。

**2.开发环境**：eclipse+mysql

**3.数据库**：shopDB

1.  字符集：utf8
2.  排序规则：utf8_general_ci
3.  数据表 Employee(员工数据表) 供货商数据表(Offers) 商品类数据表(Category)

    商品数据表(Goods) 销售数据表(Sales)

4.  数据表详细信息和字段描述见下表

| 列名(中文名) | 列名(英文名) | 数据类型     | 长度 | 默认值 | 是否为空 | 描述         |
|--------------|--------------|--------------|------|--------|----------|--------------|
| 职员编号     | Employeeid   | int          |      |        | 非空     | 主键，自增列 |
| 姓名         | EmpName      | Varchar      | 15   |        | 非空     |              |
| 密码         | EmpPwd       | varchar      | 25   |        | 非空     |              |
| 性别         | Sex          | char         | 2    |        |          |              |
| 年龄         | Age          | int          |      |        |          |              |
| 聘用日期     | HireLong     | Datetime     |      |        |          |              |
| 月薪         | Salary       | DECIMAL(7,2) |      |        |          |              |

**Employee表**

| 列名(中文名) | 列名(英文名) | 数据类型 | 长度 | 默认值 | 是否为空 | 描述         |
|--------------|--------------|----------|------|--------|----------|--------------|
| 商家编号     | OfferID      | int      |      |        | 非空     | 主键，自增列 |
| 商家名称     | OfferName    | Varchar  | 100  |        | 非空     |              |
| 法人         | LegalIP      | Varchar  | 25   |        | 非空     |              |
| 地址         | Address      | Varchar  | 200  |        | 非空     |              |
| 联系电话     | Tel          | Varchar  | 50   |        |          |              |

**Offers表**

| 列名(中文名) | 列名(英文名) | 数据类型 | 长度 | 默认值 | 是否为空 | 描述         |
|--------------|--------------|----------|------|--------|----------|--------------|
| 类别编号     | CategoryId   | Int      |      |        | 非空     | 主键，自增列 |
| 类别名称     | CategoryName | Varchar  | 50   |        | 非空     |              |

**Category表**

| 列名(中文名) | 列名(英文名) | 数据类型        | 长度 | 默认值 | 是否为空 | 描述                 |
|--------------|--------------|-----------------|------|--------|----------|----------------------|
| 商品编号     | GoodId       | int             |      |        | 非空     | 主键，自增列         |
| 商品名称     | GoodName     | Varchar         | 100  |        | 非空     |                      |
| 单价         | Price        | Decimal（7，2） |      | 0      |          |                      |
| 类别编号     | CategoryId   | Int             |      |        | 非空     | 外键，类别表的外键   |
| 供货商编号   | OfferID      | int             |      |        | 非空     | 外键，供货商表的外键 |
| 库存         | Stockes      | int             |      |        |          |                      |

**Goods表**

| 列名(中文名) | 列名(英文名) | 数据类型 | 长度 | 默认值 | 是否为空 | 描述               |
|--------------|--------------|----------|------|--------|----------|--------------------|
| 销售编号     | SalesId      | int      |      |        | 非空     | 主键 自增列        |
| 当日销量     | SellAmount   | int      |      | 0      | 非空     |                    |
| 商品编号     | GoodId       | int      |      |        | 非空     | 外键,商品表的外键  |
| 职员编号     | EmployeeId   | int      |      |        | 非空     | 外键，职员表的外键 |
| 销售日期     | SellDate     | datetime |      |        | 非空     |                    |

**Sales表**

## 4.项目描述：

### 4.1登录系统

验证用户名和密码，验证成功后则进入操作选项界面。

![](media/e0bf092cee332f5145a3967398ad9ac9.png)

验证失败则提示：用户名或密码输入错误，请重新输入。并让用户重新输入用户名和密码，再次进行验证。

![](media/9fd198b014810fbf10149ef7a30cfdb8.png)

### 4.2数据表操作

#### **4.2.1类别数据表**

如果用户选择了类别数据表，则展示类别数据表可以进行的操作

![](media/e9cf8ee1e98419bd761fe4f63115f0d6.png)

**4.2.1.1添加**

如果用户选择了添加，则先展示所有的类别信息，在控制台在进行提示：请输入类别名称，并判断类名名称是否已经存在，如果已经存在则提示用户：该类别信息已经存在，不能再次添加。如果添加成功，则提示：添加成功，反之则提示添加失败。

![](media/52d0874618ad11836081d994d8f3a6c7.png)

![](media/d1efa4476aff23a9ab057236fafefa17.png)

**4.2.1.2修改**

如果用户选择了修改，则先展示所有的类别信息，在控制台在进行提示：请 输入你要修改的类别ID，并判断该类别是否存在，如果已经存在则提示用 户：请修改类别名称；如果修改成功，则提示：修改成功，反之则提示修改 失败；如果 不存在则提示用户：抱歉，你要修改的类别信息不存在。

![](media/0a89cb0d5c762c88820d1aabbe7e8719.png)

![](media/da85de822575bbca77d219c7c36959f0.png)

**4.2.1.3删除**

如果用户选择了删除，则先展示所有的类别信息，在控制台在进行提示：请 输入你要删除的类别ID，并判断该类别是否存在，如果已经存在则提示用 户：你确定删除吗？如果用户选择是，则判断该类别下是否含有商品信息， 如果含有商品信息,则提示用户：该类别下含有商品信息，不能删除；如果该 类别下不含有商品信息，则直接删除，并根据删除与否，给予相应的提示信 息。如果该类别不存在，则提示用户：抱歉，你要删除的类别信息不存在。

![](media/2c1961eda60f4e2365d5d550a76a1462.png)

![](media/1eba2497d567ced88e0cb5c52f70d2ae.png)

![](media/3a39156260e305f1998ad8352b5bcd6a.png)

**4.2.1.4多条件查询**

如果用户选择了多条件查询，请输入你要查询的类别名称 可以模糊查询。如果 数据表中含有查询的信息，则进行展示；否职提示：抱歉，当前暂无你要的查询 信息。

![](media/08872c519a87d5fb994f8952b31dfd41.png)

![](media/4d046d1e91c86d71783dad1ca098aaba.png)

**4.2.1.5退出**

如果用户选择了退出，则展示：退出成功，欢迎下次使用！并退出Java虚拟机。

![](media/8f79361631482ad31d792983a1574571.png)

#### **4.2.2供货商数据表**

如果用户选择了供货商数据表，则展示供货商数据表可以进行的操作

![](media/fb08bd247389185b74e9982992a55cf6.png)

**4.2.2.1添加**

如果用户选择了添加，则先展示所有的供货商信息，在控制台在进行提示：依次要录入的供货商信息。并根据添加与否，给予相应的提示信息。供货商名称不能重复，如果供货商名称存在。则提示：抱歉，该供货商信息已经存在，请重新添加。

![](media/64489c0d0f48464bf6211454c710e71a.png)

![](media/2eb8ecbf6bfc3572aaf6819ed22613b5.png)

**4.2.2.2修改**

如果用户选择了修改，则先展示所有的供货商信息，在控制台在进行提示：请输入你要修改的供货商ID，并判断该供货商是否存在，如果已经存在则提示用户：依次要修改的数据信息；如果修改成功，则提示：修改成功，反之则提示修改失败；如果不存在则提示用户：抱歉，你要修改的供货商信息不存在。

![](media/32c357be8f0df496ecaa16969215ab44.png)

![](media/95ac2ac24384e286de78b15e318136bd.png)

**4.2.2.3删除**

如果用户选择了删除，则先展示所有的供货商信息，在控制台在进行提示：请输入你要删除的供货商ID，并判断该供货商是否存在，如果已经存在则提示用户：你确定删除吗？如果用户选择是，则判断该供货商下是否含有销售信息，如果含有销售信息,则提示用户：该供货商下含有商品信息，不能删除；如果该供货商下不含有商品信息，则直接删除，并根据删除与否，给予相应的提示信息。如果该供货商不存在，则提示用户：抱歉，你要删除的供货商信息不存在。

![](media/069ef7314ad4f30c624565c8e2a07e68.png)

![](media/f7cbc9d0a5658bac45d10a767167018b.png)

![](media/55e5fdd733f1338e8a43284776f30996.png)

**4.2.2.4多条件查询**

如果用户选择了多条件查询，请提示多条件查询的范围：供货商名称、法人代表、公司地址、联系电话。如果数据表中含有查询的信息，则进行展示；否则提示：抱歉，当前暂无你要的查询信息。

![](media/8efd4c331a3ca741b68f97cf5d9c554f.png)

![](media/de5183affcee685c416702326d88e542.png)**4.2.2.5退出**

如果用户选择了退出，则展示：退出成功，欢迎下次使用！并退出Java虚拟机![](media/7cd38db4c75d564346f3dd001b74cd51.png)

#### **4.2.3商品数据表**

如果用户选择了商品数据表，则展示商品数据表可以进行的操作

![](media/1eb4cc303892064c96b6651301eed321.png)

**4.2.3.1添加**

如果用户选择了添加，则先展示所有的商品信息，在控制台在进行提示：依次要 录入的商品信息。并根据添加与否，给予相应的提示信息。商品名称不能重复， 如果商品名称存在。则提示：抱歉，该商品信息已经存在，请重新添加；商品所 属的职员和供货商分别依次展示所有的职员信息和供货商信息，让用户选择所属 的职员ID和供货商ID。

![](media/307bd63a09f568694bc509db4de35586.png)

![](media/c7165a8ce1f5643e7f3893138e90a0b3.png)

![](media/97c950a7a909a39c0a9f28b72e9b7683.png)

**4.2.3.2修改**

如果用户选择了修改，则先展示所有的商品信息，在控制台在进行提示：请输入 你要修改的商品ID，并判断该商品是否存在，如果已经存在则提示用户：依次要 修改的数据信息；如果修改成功，则提示：修改成功，反之则提示修改失败；如 果不存在则提示用户：抱歉，你要修改的商品信息不存在。

![](media/330bb67b1cd4ed347d3d683d6ac7f4df.png)

![](media/15cd9c4ec4845450fe1b717bd3e05b21.png)

**4.2.3.3删除**

如果用户选择了删除，则先展示所有的商品信息，在控制台在进行提示：请输入 你要删除的商品ID，并判断该商品是否存在，如果已经存在则提示用户：你确定 删除吗？如果用户选择是，则判断该职员下是否含有销售信息，如果含有销售信 息,则提示用户：该商品下含有销售信息，不能删除；如果该职员下不含有销售信 息，则直接删除，并根据删除与否，给予相应的提示信息。如果该商品不存在， 则提示用户：抱歉，你要删除的商品信息不存在。

![](media/5c0f72b4d66cb29cfacc3a93eeef7bf3.png)

![](media/d0b9066c82d1652e71bd0ddd73f8ee2c.png)

![](media/f760c8e431d1bd96949431afe2eacb2c.png)

**4.2.3.4多条件查询**

如果用户选择了多条件查询，请提示多条件查询可以根据：商品名称、价钱区 间、所属职员、所属供货商、库存区间进行查询。如果数据表中含有查询的信 息，则进行展示；否则提示：抱歉，当前暂无你要的查询信息。

![](media/c496befca2cf56f44d479e8c0b2d99f3.png)

![](media/ead440aacf213bd64214595dee26c1d1.png)

![](media/1b2ecf088e17c50404254664bfbe7a01.png)

**4.2.3.5退出**

如果用户选择了退出，则展示：退出成功，欢迎下次使用！并退出Java虚拟机

![](media/5a7638afb6a5bf69f93f42e5759c8572.png)

#### **4.2.4销售数据表**

**4.2.4.1添加**

如果用户选择了添加，则先展示所有的销售信息，在控制台在进行提示：依次要 录入的销售信息。并根据添加与否，给予相应的提示信息。

![](media/c75d5c18725374475ef7bd165de66426.png)

![](media/cd6ff373bf6eefcb87fd4a33a4721bd8.png)

**4.2.4.2修改**

如果用户选择了修改，则先展示所有的销售信息，在控制台在进行提示：请输入 你要修改的销售ID，并判断该销售是否存在，如果已经存在则提示用户：依次要 修改的数据信息；如果修改成功，则提示：修改成功，反之则提示修改失败；如 果不存在则提示用户：抱歉，你要修改的销售信息不存在。

![](media/70dab71891f90f7a904426b39cea2ae1.png)

![](media/8dcb22b50c48518532bd8602ee1b8252.png)

**4.2.4.3删除**

如果用户选择了删除，则先展示所有的销售信息，在控制台在进行提示：请输入 你要删除的销售ID，并判断该销售是否存在，如果已经存在则提示用户：你确定 删除吗？如果用户选择是，则进行删除，并根据删除与否，给予相应的提示信 息。如果该销售不存在，则提示用户：抱歉，你要删除的销售信息不存在。

![](media/2c5beac5ee6d00ed5d666a3881cf4764.png)

![](media/e419aec479209db58ffdb1d339d1d523.png)

**4.2.3.4多条件查询**

如果用户选择了多条件查询，则提示多条件查询可以根据：数量区间、商品名 称、职员姓名、销售日期区间 进行多条件查询。如果数据表中含有查询的信息， 则进行展示；否则提示：抱歉，当前暂无你要的查询信息。

![](media/95ac2ac24384e286de78b15e318136bd.png)

![](media/ecfeab26ba8f9fdf53ca3b5c03c8bba0.png)

**4.2.3.5退出**

如果用户选择了退出，则展示：退出成功，欢迎下次使用！并退出Java虚拟机

![](media/1a9017512819d849e039fdec6af5747f.png)

#### **4.2.5职员数据表**

如果用户选择了职员数据表，则展示职员数据表可以进行的操作

![](media/fd77afbdcba98c5230a1763e4557c089.png)

**4.2.5.1添加**

如果用户选择了添加，则先展示所有的职员信息，在控制台在进行提示：依次要 添加的数据信息。其中密码的长度必须大于6位，输入的两次密码必须相等；性 别只能是男或女；年龄和薪水必须大于0，并根据添加与否，给予相应的提示信 息。

![](media/2607ebc64b5089f6051729bab5f754e8.png)

**4.2.5.2修改**

如果用户选择了修改，则先展示所有的职员信息，在控制台在进行提示：请输入 你要修改的职员ID，并判断该职员是否存在，如果已经存在则提示用户：依次要 修改的数据信息；如果修改成功，则提示：修改成功，反之则提示修改失败；如 果不存在则提示用户：抱歉，你要修改的职员信息不存在。

![](media/950ca2a878e06a14aba02657e9e7375a.png)

![](media/84719b8cde32a6875b5a08b492ee0a11.png)

**4.2.5.3删除**

如果用户选择了删除，则先展示所有的职员信息，在控制台在进行提示：请输入 你要删除的职员ID，并判断该职员是否存在，如果已经存在则提示用户：你确定 删除吗？如果用户选择是，则判断该职员下是否含有销售信息，如果含有销售信 息,则提示用户：该职员下含有销售信息，不能删除；如果该职员下不含有销售信 息，则直接删除，并根据删除与否，给予相应的提示信息。如果该职员不存在， 则提示用户：抱歉，你要删除的职员信息不存在。

![](media/57330e5c0e17d8f68e6eebb3a2a1f9e7.png)

![](media/cd481555ea1912185fe08d9065e54008.png)

![](media/03ed2371d1d15c33b159ea83bb3037a7.png)

**4.2.5.4多条件查询**

如果用户选择了多条件查询，提示：员工表可以进行多条件查询的字段有：员工姓 名、性别、年龄区间、入职日期区间、薪酬区间。其中员工姓名为模糊查询。如果 数据表中含有查询的信息，则进行展示；否职提示：抱歉，当前暂无你要的查询 信息。

![](media/ab2e35b29aaa3f4150731ba068ce220c.png)

![](media/15a0f42b2bcd0e0bdfb017946ea598b9.png)

**4.2.5.5退出**

如果用户选择了退出，则展示：退出成功，欢迎下次使用！并退出Java虚拟机。

![](media/6b17b0e86379781373c9a315a4cbb156.png)
