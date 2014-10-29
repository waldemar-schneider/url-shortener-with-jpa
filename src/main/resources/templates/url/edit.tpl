def title = url.id != null ? 'edit url' : 'create url'
layout 'layout.tpl', title: "$title", content: contents {


    nav (class: 'breadcrumbs') {
        a (href: '/', 'Home')
        a (href: '/url/', 'url adminstration')
        a (href: '#', onclick: 'return false;', class: 'current', title)
    }

    h2 title

    p {
        form (action: '/url/save', method: 'post') {
            input(name: 'id', value: url.id, type: 'hidden')

            div (class: 'row') {

                div (class: 'large-4 columns left') {
                    label(for: 'url', class: bindingResult?.hasFieldErrors('url') ? 'error': '', 'URL')
                    input(name: 'url', class: bindingResult?.hasFieldErrors('url') ? 'error': '',
                                type: 'url', id: 'url', placeholder: 'https://example.com', value: url.url)

                    if (bindingResult?.hasFieldErrors('url')) {
                        small (class: 'error', bindingResult.getFieldError('url').getDefaultMessage())
                    }
                }
            }


            input(class: 'button', name: 'submit', type: 'submit', id: 'save')
            a (href: '/url/', class: "button", onclick:
                    "if (!confirm('Do you really want to cancel the current process and return to the list view?')) return false;", "Cancel")
        }
    }
}