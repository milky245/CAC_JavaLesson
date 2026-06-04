document.addEventListener("DOMContentLoaded", () => {
	const updateCount = (textarea) => {
		const field = textarea.closest(".field");
		const count = field ? field.querySelector(".js-count") : null;
		if (count) {
			count.textContent = textarea.value.length;
		}
	};

	document.querySelectorAll(".js-countable").forEach((textarea) => {
		updateCount(textarea);
		textarea.addEventListener("input", () => updateCount(textarea));
	});

	const firstError = document.querySelector(".field-error:not(:empty), .alert:not(:empty)");
	if (firstError) {
		firstError.scrollIntoView({ block: "center" });
	}

	const deleteForm = document.querySelector(".js-delete-form");
	if (deleteForm) {
		deleteForm.addEventListener("submit", (event) => {
			const checked = deleteForm.querySelectorAll("input[name='checkIds']:checked");
			if (checked.length === 0) {
				event.preventDefault();
				window.alert("削除するコメントを選択してください。");
				return;
			}
			if (!window.confirm(`${checked.length}件のコメントを削除します。よろしいですか？`)) {
				event.preventDefault();
			}
		});
	}
});
