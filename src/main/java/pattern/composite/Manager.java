package pattern.composite;

import java.util.ArrayList;

public class Manager extends Staff {

    private final ArrayList<Staff> staffList = new ArrayList<Staff>();

    public Manager(String no, String name, String position, double salary) {
        super(no, name, position, salary);
    }

    /**
     * ���Ա��
     *
     * @param staff Ա������
     */
    public void add(Staff staff) {
        staffList.add(staff);
    }

    /**
     * ���ݹ����Ƴ�ĳ��Ա��
     */
    public Staff remove(String no) {
        Staff staff = null;
        if (no == null || "".equals(no.trim())) {
            return null;
        }
        for (Staff s : staffList) {
            if (no.equals(s.getNo())) {
                staffList.remove(s);
                staff = s;
                break;
            }
        }
        return staff;
    }

    @Override
    public void printEmployeesInfo() {
        for (Staff staff : staffList) {
            if (staff == null) {
                continue;
            }
            staff.printBasicInfo();
            staff.printEmployeesInfo();
        }
    }

}
