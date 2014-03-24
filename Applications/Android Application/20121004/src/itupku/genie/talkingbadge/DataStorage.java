package itupku.genie.talkingbadge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class DataStorage extends Service {
	private static final String TAG = "DataStorage";
	private final IBinder DSBinder = new DSBinder();
	private static boolean mExternalStorageWriteable;
	private static String tbDirName = "TalkingBadge";
	private static String btDirName = "bluetooth";
	// Talking Badge Dir
	private static File tbDir;
	// bluetooth Dir
	private static File btDir;
	private static File rootDir;
	private static File externalDir;
	// Log file Dir
	private static File logFile;
	private static File matchFile;
	private static File soundHistoryFile;

	public boolean init() {
		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state)) {
			mExternalStorageWriteable = true;
		} else {
			mExternalStorageWriteable = false;
		}

		if (mExternalStorageWriteable) {
			tbDir = Environment.getExternalStoragePublicDirectory(tbDirName);
			btDir = Environment.getExternalStoragePublicDirectory(btDirName);
			rootDir=Environment.getRootDirectory();
			externalDir=Environment.getExternalStorageDirectory();
			tbDir.deleteOnExit();
			try {
				tbDir.mkdir();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			logFile = new File(tbDir.getAbsolutePath(), "TalkingBadge.log");
			matchFile = new File(tbDir.getAbsolutePath(),
					TalkingBadgeActivity.matchXMLFile);
			soundHistoryFile = new File(tbDir.getAbsolutePath(),
					TalkingBadgeActivity.soundHistoryTXTFile);
			if (!tbDir.exists()) {
				tbDir.mkdirs();
			}
			if (!btDir.exists()) {
				btDir.mkdirs();
			}

			try {
				if (!logFile.exists()) {
					logFile.createNewFile();
					// Log.d(TAG, "File Created:" + logFile.getAbsolutePath());
					// hiding the files from media scanner
					(new File(tbDir.getAbsolutePath(), ".nomedia"))
							.createNewFile();
				}
				File dest = new File(tbDir.getAbsolutePath(),
						TalkingBadgeActivity.introductionMessageSoundFile);
				dest.deleteOnExit();
				dest.createNewFile();
				InputStream input = getResources().openRawResource(
						R.raw.introduction_message);
				FileOutputStream output = new FileOutputStream(dest);
				byte[] buf = new byte[1024];
				int len;
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
					// Log.e(TAG, "File rite:" + buf);
				}

				dest = new File(tbDir.getAbsolutePath(),
						TalkingBadgeActivity.lowBatteryAlertSoundFile);
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.low_battery_alert);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
					// Log.e(TAG, "File rite:" + buf);
				}

				dest = new File(tbDir.getAbsolutePath(), "femalefloor2ch.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.femalefloor2ch);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "femalefloor2dk.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.femalefloor2dk);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "femalefloor2en.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.femalefloor2en);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "femalefloor3ch.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.femalefloor3ch);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "femalefloor3dk.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.femalefloor3dk);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "femalefloor3en.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.femalefloor3en);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "femalefloor4ch.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.femalefloor4ch);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "femalefloor4dk.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.femalefloor4dk);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "femalefloor4en.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.femalefloor4en);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "femalefloor5ch.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.femalefloor5ch);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "femalefloor5dk.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.femalefloor5dk);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "femalefloor5en.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.femalefloor5en);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "femalehappych.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.femalehappych);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "femalehappydk.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.femalehappydk);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "femalehappyen.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.femalehappyen);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}

				dest = new File(tbDir.getAbsolutePath(), "malefloor2ch.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.malefloor2ch);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "malefloor2dk.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.malefloor2dk);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "malefloor2en.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.malefloor2en);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "malefloor3ch.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.malefloor3ch);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "malefloor3dk.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.malefloor3dk);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "malefloor3en.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.malefloor3en);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "malefloor4ch.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.malefloor4ch);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "malefloor4dk.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.malefloor4dk);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "malefloor4en.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.malefloor4en);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "malefloor5ch.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.malefloor5ch);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "malefloor5dk.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.malefloor5dk);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "malefloor5en.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.malefloor5en);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "malehappych.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.malehappych);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "malehappydk.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.malehappydk);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				dest = new File(tbDir.getAbsolutePath(), "malehappyen.mp3");
				dest.deleteOnExit();
				dest.createNewFile();
				input = getResources().openRawResource(R.raw.malehappyen);
				output = new FileOutputStream(dest);
				buf = new byte[1024];
				while ((len = input.read(buf)) > 0) {
					output.write(buf, 0, len);
				}
				
				/* note: quick fix for adding some new messages
				 * we use the id from talkingbadge-server / client but android dont like numbers as ids for R.raw.id
				 * so its added tb<some id> but we like the final file name to be the same
				 */ 
				RawAndroidFile rawFiles[]  = {
					new RawAndroidFile(R.raw.tbd026f87313ecd058a46212fabbbd8795, "d026f87313ecd058a46212fabbbd8795.mp3"),
					new RawAndroidFile(R.raw.tba80f0a5815f2666cfa190c774b04df33, "a80f0a5815f2666cfa190c774b04df33.mp3"),
					new RawAndroidFile(R.raw.tb1b995552fc67b8d30c96ca360ef81ea3, "1b995552fc67b8d30c96ca360ef81ea3.mp3"),
					new RawAndroidFile(R.raw.tb5f2084f9c5c76cad75b4aa2582f3bf3a, "5f2084f9c5c76cad75b4aa2582f3bf3a.mp3"),
					new RawAndroidFile(R.raw.tb3b628526652bba26bf95e862434cd0cc, "3b628526652bba26bf95e862434cd0cc.mp3"),
					new RawAndroidFile(R.raw.tb77f302d29f37db4b91c21bd6279f8d2f, "77f302d29f37db4b91c21bd6279f8d2f.mp3"),
					new RawAndroidFile(R.raw.tb8d396e895790acb381593186bf750ce5, "8d396e895790acb381593186bf750ce5.mp3"),
					new RawAndroidFile(R.raw.tb175bdfd3ebe90de946884e83362a8984, "175bdfd3ebe90de946884e83362a8984.mp3"),
					new RawAndroidFile(R.raw.ping, "ping.mp3")
				};
				
				for (RawAndroidFile rawFile: rawFiles ) {
					dest = new File(tbDir.getAbsolutePath(), rawFile.getFileName());
					dest.deleteOnExit();
					dest.createNewFile();
					input = getResources().openRawResource(rawFile.getRawId());
					output = new FileOutputStream(dest);
					buf = new byte[1024];
					while ((len = input.read(buf)) > 0) {
						output.write(buf, 0, len);
					}
				}
				
				if (!matchFile.exists()) {
					matchFile.createNewFile();
					input = getResources().openRawResource(R.raw.matches);
					output = new FileOutputStream(matchFile);
					while ((len = input.read(buf)) > 0) {
						output.write(buf, 0, len);
					}
				}
				if (!soundHistoryFile.exists()) {
					soundHistoryFile.createNewFile();
					input = getResources().openRawResource(R.raw.soundhistory);
					output = new FileOutputStream(soundHistoryFile);
					while ((len = input.read(buf)) > 0) {
						output.write(buf, 0, len);
					}
				}
				output.flush();
				output.close();
				input.close();
				// Log.e(TAG, "File Created:" + dest.getAbsolutePath());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				Log.e(TAG + "1", e.toString());
				Toast.makeText(this, "Data Storage Error", Toast.LENGTH_LONG)
						.show();

				return false;
			}
		}

		return true;
	}

	@Override
	public IBinder onBind(Intent arg0) {
		init();
		return DSBinder;
	}

	public int onStartCommand(Intent intent, int flags, int startId) {
		init();
		return startId;
	}

	public static synchronized boolean expandLog(String newLog) {
		if (mExternalStorageWriteable) {
			try {
				if (!logFile.exists()) {
					logFile.createNewFile();
				}
				BufferedWriter output = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(logFile,
								true)));
				output.write(newLog + "\n");
				output.close();
			} catch (Exception e) {
				Log.e(TAG + "2", e.toString());
				return false;
			}

			return true;
		} else
			return false;
	}

	public static synchronized File findFile(String name) {
		if (mExternalStorageWriteable) {
			try {
				File theFile = null;
				theFile = new File(btDir.getAbsolutePath(), name);
				if (theFile.exists()) {
					return theFile;
				}
				theFile = new File(tbDir.getAbsolutePath(), name);
				if (theFile.exists()) {
					return theFile;
				}
				theFile = new File(rootDir.getAbsolutePath(), name);
				if (theFile.exists()) {
					return theFile;
				}
				theFile = new File(externalDir.getAbsolutePath(), name);
				if (theFile.exists()) {
					return theFile;
				}

			} catch (Exception e) {
				Log.e(TAG + "3", e.toString());
				return null;
			}
		}
		return null;
	}

	public static synchronized boolean clearLog() {
		try {
			File theFile = logFile;
			if (theFile.exists()) {
				theFile.delete();
				return logFile.createNewFile();
			}
		} catch (Exception e) {
			Log.e(TAG + "4", e.toString());
			return false;
		}
		return false;
	}

	public static synchronized String readLog() {
		try {
			File theFile = logFile;
			if (!theFile.exists()) {
				return "";
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(theFile)));
			String data = null;
			String replay = "";
			while ((data = br.readLine()) != null) {
				replay = replay.concat("\n" + data);
			}
			br.close();
			return replay;
		} catch (Exception e) {
			Log.e(TAG + "5", e.toString());
			return null;
		}
	}

	public static synchronized String ListFile() {
		String result = "";
		try {
			File[] theFiles = tbDir.listFiles();
			for (File f : theFiles) {
				if (f.getName().endsWith("mp3"))
					result = result.concat(f.getName() + " ");
			}
			theFiles = btDir.listFiles();
			for (File f : theFiles) {
				if (f.getName().endsWith("mp3"))
					result = result.concat(f.getName() + " ");
			}
			theFiles = rootDir.listFiles();
			for (File f : theFiles) {
				if (f.getName().endsWith("mp3"))
					result = result.concat(f.getName() + " ");
			}
			theFiles = externalDir.listFiles();
			for (File f : theFiles) {
				if (f.getName().endsWith("mp3"))
					result = result.concat(f.getName() + " ");
			}
		} catch (Exception e) {
			Log.e(TAG + "6", e.toString());
			return null;
		}
		return result;
	}

	public class DSBinder extends Binder {
		DataStorage getService() {
			return DataStorage.this;
		}
	}

	public static synchronized LinkedList<String> readSoundHistory() {
		try {

			File theFile = soundHistoryFile;
			// Log.e(TAG + "71", theFile.toString());
			if (!theFile.exists()) {
				theFile.createNewFile();
				Log.e(TAG + "72", theFile.toString());
				return null;
			}
			// Log.e(TAG + "73", theFile.toString());
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(theFile)));
			String data = null;
			LinkedList<String> replay = new LinkedList<String>();
			while ((data = br.readLine()) != null) {
				replay.add(data);
			}
			br.close();
			return replay;
		} catch (Exception e) {
			Log.e(TAG + "7", e.toString());
			return null;
		}
	}

	public static synchronized boolean writeSoundHistory(
			LinkedList<String> sounds) {
		// Log.e(TAG + "81", "Write "+sounds);
		if (mExternalStorageWriteable) {
			try {
				if (!soundHistoryFile.exists()) {
					soundHistoryFile.createNewFile();
				}
				BufferedWriter output = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(
								soundHistoryFile, false)));
				for (String sound : sounds)
					output.write(sound + "\n");
				output.close();
			} catch (Exception e) {
				Log.e(TAG + "8", e.toString());
				return false;
			}

			return true;
		} else
			return false;
	}
	
	
	private class RawAndroidFile {
		private int rawId;
		private String fileName;
		RawAndroidFile(int rawId, String fileName) {
			this.rawId=rawId;
			this.fileName=fileName;
		}
		public int getRawId() {
			return this.rawId;
		}
		public String getFileName(){
			return this.fileName;
		}
	}
	
}


