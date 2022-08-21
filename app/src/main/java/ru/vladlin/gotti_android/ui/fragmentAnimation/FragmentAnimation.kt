package ru.vladlin.gotti_android.ui.fragmentAnimation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import ru.vladlin.gotti_android.databinding.FragmentListBinding
import ru.vladlin.gotti_android.lifecycle.ViewModelFactory
import ru.vladlin.gotti_android.lifecycle.injectViewModel
import ru.vladlin.gotti_android.ui.MainActivity
import ru.vladlin.gotti_android.ui.epoxy.EpoxyController
import javax.inject.Inject

class FragmentAnimation : Fragment() {

    private lateinit var viewModel: ViewModelAnimation
    private lateinit var binding: FragmentListBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    val fragmentListComponent by lazy {
        return@lazy (requireActivity() as MainActivity).feedComponent
    }

    val epoxyController: EpoxyController = EpoxyController()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentListComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater)

        binding.swipeRefresh.setOnRefreshListener {
            viewModel.loadData()
        }

        binding.epoxyRecyclerView.setController(epoxyController)

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        viewModel = injectViewModel(viewModelFactory)
        viewModel.loadData()

        viewModel.dataFeed.observe(viewLifecycleOwner) {
            epoxyController.setData(it)
        }

        viewModel.isRefreshed.observe(viewLifecycleOwner) {
            binding.swipeRefresh.isRefreshing = it
        }

        viewModel.errorSnackbar.observe(viewLifecycleOwner) {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG)
                .show()
        }
    }

}