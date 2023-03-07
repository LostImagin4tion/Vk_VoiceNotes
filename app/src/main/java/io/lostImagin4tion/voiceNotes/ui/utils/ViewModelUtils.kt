package io.lostImagin4tion.voiceNotes.ui.utils

import androidx.annotation.StringRes
import io.lostImagin4tion.voiceNotes.R
import timber.log.Timber

inline fun <T> MutableResultFlow<T>.loadOrError(
    @StringRes messageId: Int = R.string.common_error_message,
    preserveValue: Boolean = true,
    showLoading: Boolean = true,
    load: () -> T?
) {
    if (showLoading) {
        value = LoadingResult(value.data.takeIf { preserveValue })
    }

    value = try {
        SuccessResult(load())
    } catch (e: Exception) {
        Timber.e(e)
        ErrorResult(messageId)
    }
}