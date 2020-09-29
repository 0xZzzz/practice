package pattern.visitor;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理人员(手下有其他员工的人)
 *
 * @author 0xZzzz
 */
public class Manager extends Staff {

    /**
     * 保存手下员工信息
     */
    private final List<Staff> staffList = new ArrayList<>();

    public Manager(String no, String name, String position, float salary) {
        super(no, name, position, salary);
    }

    @Override
    public void add(Staff staff) {
        // 增加员工
        this.staffList.add(staff);
    }

    @Override
    public Staff remove(String no) {
        // 根据员工号删除员工
        Staff delStaff = null;
        if (StringUtils.isNotBlank(no)) {
            for (Staff staff : staffList) {
                if (staff == null) {
                    continue;
                }
                if (staff.getNo().equals(no)) {
                    delStaff = staff;
                    staffList.remove(staff);
                }
            }
        }
        return delStaff;
    }

    @Override
    public void accept(IVisitor visitor) {
        // 接受访问者对象
        // 访问自身
        visitor.visit(this);
        for (Staff staff : staffList) {
            if (staff == null) {
                continue;
            }
            // 接受访问者对象
            staff.accept(visitor);
        }
    }

}
