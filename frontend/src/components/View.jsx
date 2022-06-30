import { Viewer } from '@toast-ui/react-editor';
import '@toast-ui/editor/dist/toastui-editor.css';
import codeSyntaxHighlight from '@toast-ui/editor-plugin-code-syntax-highlight';
import '@toast-ui/editor-plugin-code-syntax-highlight/dist/toastui-editor-plugin-code-syntax-highlight.css';

import Prism from 'prismjs';
import 'prismjs/themes/prism.css';

const test = `
	# 반갑습니다 
	## 고맙습니다
`
const View = () => {
	return (
		<Viewer
			initialValue={test}
			plugins={[[codeSyntaxHighlight, { highlighter: Prism }]]}
		/>
	);
}

export default View