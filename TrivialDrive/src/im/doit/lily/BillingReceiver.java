package im.doit.lily;

import im.doit.lily.util.ResponseCode;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BillingReceiver extends BroadcastReceiver {

	private static final String TAG = "BillingReceiver";

	// Intent actions that we receive in the BillingReceiver from Google Play.
	// These are defined by Google Play and cannot be changed.
	// The sample application defines these in the Consts.java file.
	public static final String ACTION_NOTIFY = "com.android.vending.billing.IN_APP_NOTIFY";
	public static final String ACTION_RESPONSE_CODE = "com.android.vending.billing.RESPONSE_CODE";
	public static final String ACTION_PURCHASE_STATE_CHANGED = "com.android.vending.billing.PURCHASE_STATE_CHANGED";

	// The intent extras that are passed in an intent from Google Play.
	// These are defined by Google Play and cannot be changed.
	// The sample application defines these in the Consts.java file.
	public static final String NOTIFICATION_ID = "notification_id";
	public static final String INAPP_SIGNED_DATA = "inapp_signed_data";
	public static final String INAPP_SIGNATURE = "inapp_signature";
	public static final String INAPP_REQUEST_ID = "request_id";
	public static final String INAPP_RESPONSE_CODE = "response_code";

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		if (ACTION_PURCHASE_STATE_CHANGED.equals(action)) {
			String signedData = intent.getStringExtra(INAPP_SIGNED_DATA);
			String signature = intent.getStringExtra(INAPP_SIGNATURE);
			// Do something with the signedData and the signature.
		} else if (ACTION_NOTIFY.equals(action)) {
			String notifyId = intent.getStringExtra(NOTIFICATION_ID);
			// Do something with the notifyId.
		} else if (ACTION_RESPONSE_CODE.equals(action)) {
			long requestId = intent.getLongExtra(INAPP_REQUEST_ID, -1);
			int responseCodeIndex = intent.getIntExtra(INAPP_RESPONSE_CODE, ResponseCode.RESULT_ERROR.ordinal());
			// Do something with the requestId and the responseCodeIndex.
		} else {
			Log.w(TAG, "unexpected action: " + action);
		}
	}
	// Perform other processing here, such as forwarding intent messages to your
	// local service.
}