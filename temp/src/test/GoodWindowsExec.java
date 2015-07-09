package test;

public class GoodWindowsExec {
	public static void main(String args[]) {
		if (args.length < 1) {
			System.out.println("USAGE: java GoodWindowsExec <cmd>");
			//System.exit(1);
		}

		try {
			String osName = System.getProperty("os.name");
			String[] cmd = new String[3];
			System.out.println(osName);
			if (osName.equals("Windows NT (unknown)")) {
				cmd[0] = "cmd.exe";
				cmd[1] = "/C";
				cmd[2] = "dir *.*";
				//cmd[2] = args[0];
			} else if (osName.equals("Windows 95")) {
				cmd[0] = "command.com";
				cmd[1] = "/C";
				cmd[2] = "dir *.*";
				//cmd[2] = args[0];
			}
			else if (osName.equals("Windows 2003")) {
				cmd[0] = "sqlplus";
				cmd[1] = "marineadmin/usoft@MARINE_10.200.250.115";
				cmd[2] = "";
//				cmd[0] = "sqlplus";
//				cmd[1] = "";
//				cmd[2] = "";
			}
			//marineadmin/usfot@MARINE_10.200.250.115
			Runtime rt = Runtime.getRuntime();
			System.out.println("Execing " + cmd[0] + " " + cmd[1] + " "
					+ cmd[2]);
			Process proc = rt.exec(cmd);
			// any error message?
			StreamGobbler errorGobbler = new StreamGobbler(proc
					.getErrorStream(), "ERROR");

			// any output?
			StreamGobbler outputGobbler = new StreamGobbler(proc
					.getInputStream(), "OUTPUT");

			// kick them off
			errorGobbler.start();
			outputGobbler.start();

			// any error???
			int exitVal = proc.waitFor();
			proc.wait(500);proc.destroy();
			System.out.println("ExitValue:");
			System.out.println("ExitValue: " + exitVal);
			
			//
			cmd[0] = "marineadmin/usoft@MARINE_10.200.250.115";
			System.out.println("Execing " + cmd[0] + " " + cmd[1] + " "
					+ cmd[2]);
			proc = rt.exec(cmd);
			// any error message?
			errorGobbler = new StreamGobbler(proc
					.getErrorStream(), "ERROR");

			// any output?
			outputGobbler = new StreamGobbler(proc
					.getInputStream(), "OUTPUT");

			// kick them off
			errorGobbler.start();
			outputGobbler.start();

			// any error???
			exitVal = proc.waitFor();
			System.out.println("ExitValue: " + exitVal);
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
