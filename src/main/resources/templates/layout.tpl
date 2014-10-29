yieldUnescaped '<!DOCTYPE html>'

html (class: 'no-js', lang: 'en') {
comment '[if IE 9]><html class="lt-ie10" lang="en" > <![endif]'

    head {
        include template: 'html-header.tpl'
    }

	body {

        include template: 'header.tpl'

        div (class: 'row') {

            // include template: 'sidebar-left.tpl'

            div (class: 'large-12 columns') {
                content()
            }

            // include template: 'sidebar-right.tpl'
        }

        include template: 'footer.tpl'
	}
}
