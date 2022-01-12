package com.getter.kollytsi.ui

import android.animation.Animator
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import com.getter.kollytsi.R
import com.getter.kollytsi.databinding.ItemSlotBinding

class OneSlot : FrameLayout {

    lateinit var binding: ItemSlotBinding
    private val animDuration = 170
    private var count = 0

    fun getAccess() {
        Log.d("One Slot", "init")
    }

    constructor(context: Context) : super(context) {
        initSlot(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initSlot(context)
    }

    private fun initSlot(context: Context) {
        LayoutInflater.from(context).inflate(R.layout.item_slot, this)
        binding = ItemSlotBinding.bind(this)
        binding.nextImage.translationY = height.toFloat()
    }

    fun animIteration(imgNumber: Int, numOfRolls: Int, numberOfLine: Int) {
        binding.currentImage.animate()
            .translationY(-height.toFloat())
            .setDuration(animDuration.toLong()).start()

        binding.nextImage.translationY = binding.nextImage.height.toFloat()

        binding.nextImage.animate()
            .translationY(0f)
            .setDuration(animDuration.toLong())
            .setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(p0: Animator?) = Unit

                override fun onAnimationEnd(p0: Animator?) {
                    setImage(binding.currentImage, count % 5)
                    binding.currentImage.translationY = 0f
                    if (count < numOfRolls) {
                        animIteration(imgNumber, numOfRolls, numberOfLine)
                        count++
                    } else {
                        setImage(binding.nextImage, count % 5)
                        Values.listOfResultImages[numberOfLine - 1] = count % 5
                        checkIfEnd()
                        count = 0
                    }
                }

                override fun onAnimationCancel(p0: Animator?) = Unit

                override fun onAnimationRepeat(p0: Animator?) = Unit
            }).start()
    }

    fun setImage(currentImage: ImageView, detailNumber: Int) {
        when (detailNumber) {
            0 -> currentImage.setImageResource(R.drawable.f9)
            1 -> currentImage.setImageResource(R.drawable.f10)
            2 -> currentImage.setImageResource(R.drawable.f11)
            3 -> currentImage.setImageResource(R.drawable.f12)
            4 -> currentImage.setImageResource(R.drawable.f9)
        }
    }

    fun checkIfEnd() {
        if (!Values.listOfResultImages.contains(100)) {
            Values.endOfGame.postValue(true)
        }
    }
}