package pattern.visitor;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ������Ա(����������Ա������)
 *
 * @author 0xZzzz
 */
public class Manager extends Staff {

    /**
     * ��������Ա����Ϣ
     */
    private final List<Staff> staffList = new ArrayList<>();

    public Manager(String no, String name, String position, float salary) {
        super(no, name, position, salary);
    }

    @Override
    public void add(Staff staff) {
        // ����Ա��
        this.staffList.add(staff);
    }

    @Override
    public Staff remove(String no) {
        // ����Ա����ɾ��Ա��
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
        // ���ܷ����߶���
        // ��������
        visitor.visit(this);
        for (Staff staff : staffList) {
            if (staff == null) {
                continue;
            }
            // ���ܷ����߶���
            staff.accept(visitor);
        }
    }

}
