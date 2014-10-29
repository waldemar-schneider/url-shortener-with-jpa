def title = 'all urls'

layout 'layout.tpl', title: "url managing: $title", content: contents {

    nav (class: 'breadcrumbs') {
        a (href: '/', 'Home')
        a (href: '#', onclick: 'return false;', class: 'current', title)
    }

    h2 title

    a (href: '/url/add', class: 'button small', 'add new url')

    table {
        thead {
            tr {
                th 'ID'
                th 'Hash'
                th 'URL'
                th ''
            }
        }
        urls.each { url ->
            tr {
                td url.id
                td { a(href: "/url/${url.id}", "${url.hash}") }
                td { a(href: "/url/${url.id}", "${url.url}") }
                td {
                    form (action: "/url/${url.id}/delete", method: 'post') {
                        input(name: '_method', value: 'delete', type: 'hidden')
                        input(name: 'submit', class: 'button tiny inline', type: 'submit', id: 'delete', value: 'delete')
                    }
                }
            }
        }
    }
}
