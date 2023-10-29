public class demoDaoimpl extends BaseDao implements demoDao {
    
    @Override
    public void add() {
    super.getConnection();
    String sql = "insert into Dept values(?,?,?)";
    try {
    ps = conn.prepareStatement(sql);
    ps.setInt(1, 1);
    ps.setString(2, "张三");
    ps.setString(3, "男");
    ps.executeUpdate();
    } catch (Exception e) {
    e.printStackTrace();
    } finally {
    super.connClose();
    }
}
}
