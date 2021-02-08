package com.techwireme.athath.util

import android.content.Context
import android.graphics.Bitmap
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.dotinfiny.banglesystem.R
import com.dotinfiny.banglesystem.Utils.RoundedCornersTransformation

fun Context.loadImage(imageUrl: String, imgview: ImageView, fm: FrameLayout?) {
    Glide.with(this).load(imageUrl)

        .apply(RequestOptions.skipMemoryCacheOf(true))
        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
        .apply(
            RequestOptions.bitmapTransform(
                RoundedCornersTransformation(this, 14, 2, "#558548", 3)
            )
        )
        .into(imgview);
    if (fm != null) {
        fm.background = null
    }
}

fun Context.loadImageWithCache(imageUrl: String, imgview: ImageView, fm: FrameLayout?) {
    Glide.with(this).load(imageUrl)

        .apply(RequestOptions.skipMemoryCacheOf(false))
        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
        .apply(
            RequestOptions.bitmapTransform(
                RoundedCornersTransformation(this, 14, 2, "#558548", 3)
            )
        )
        .into(imgview);
    if (fm != null) {
        fm.background = null
    }
}

fun Context.loadImage(bitmap: Bitmap, imgview: ImageView, fm: RelativeLayout?) {
    Glide.with(this).load(bitmap)
        .apply(RequestOptions.skipMemoryCacheOf(true))
        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))

        .apply(
            RequestOptions.bitmapTransform(
                RoundedCornersTransformation(this, 14, 2, "#558548", 3)
            )
        )
        .into(imgview);
    if (fm != null) {
        fm.background = null
    }
}

fun Context.loadImage(imageUrl: String, imgview: ImageView) {
    Glide.with(this).load(imageUrl)
        .placeholder(R.drawable.image_bg)
        .error(R.drawable.image_bg)
        .apply(RequestOptions.skipMemoryCacheOf(true))
        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
        .apply(
            RequestOptions.bitmapTransform(
                RoundedCornersTransformation(this, 14, 2, "#558548", 3)
            )
        )
        .into(imgview);

}
