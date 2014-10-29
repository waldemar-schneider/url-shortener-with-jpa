footer (class: 'row') {
    div (class: 'large-12 columns') {
        hr () {}
        div (class: 'row') {
            div (class: 'large-5 columns') {
                p ('&copy; Copyright no one at all. Go to town.')
            }

            div (class: 'large-7 columns') {
                ul (class: 'inline-list right') {
                    li { a (href: '/url', 'manage all URLs') }
                }
            }

        }
    }
}

script(src: '/js/vendor/jquery.js') {}
script(src: '/js/foundation/foundation.js') {}

script {
      yield '$(document).foundation();'
      yield 'var doc = document.documentElement;'
      yieldUnescaped 'doc.setAttribute(\'data-useragent\', navigator.userAgent);'
}