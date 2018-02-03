package netty.udp.log;

import java.net.InetSocketAddress;

/**
 * 日志事件
 */
public class LogEvent {

    public static final byte SEPARATOR = (byte) '#';

    private final InetSocketAddress source; //地址

    private final String logfile; //日志文件

    private final String msg; //消息

    private final long received; //接受时间

    public LogEvent(String logfile, String msg) {
        this(null, logfile, msg, -1);
    }

    public LogEvent(InetSocketAddress source, String logfile, String msg, long received) {
        this.source = source;
        this.logfile = logfile;
        this.msg = msg;
        this.received = received;
    }

    public InetSocketAddress getSource() {
        return source;
    }

    public String getLogfile() {
        return logfile;
    }

    public String getMsg() {
        return msg;
    }

    public long getReceived() {
        return received;
    }
}
