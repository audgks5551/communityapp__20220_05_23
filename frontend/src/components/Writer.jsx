import { useRef } from 'react';

import { Editor } from '@toast-ui/react-editor';
import '@toast-ui/editor/dist/toastui-editor.css';
import colorSyntax from '@toast-ui/editor-plugin-color-syntax';
import codeSyntaxHighlight from '@toast-ui/editor-plugin-code-syntax-highlight';
import '@toast-ui/editor-plugin-color-syntax/dist/toastui-editor-plugin-color-syntax.css';
import '@toast-ui/editor-plugin-code-syntax-highlight/dist/toastui-editor-plugin-code-syntax-highlight.css';
import 'tui-color-picker/dist/tui-color-picker.css';

import Prism from 'prismjs';
import 'prismjs/themes/prism.css';

const Writer = () => {
    const editorRef = useRef();

    // 등록 버튼 핸들러
    const handleRegisterButton = () => {
        // 입력창에 입력한 내용을 HTML 태그 형태로 취득
        console.log(editorRef.current?.getInstance().getHTML());
        // 입력창에 입력한 내용을 MarkDown 형태로 취득
        console.log(editorRef.current?.getInstance().getMarkdown());
    };

    return (
        <>
            <Editor
                ref={editorRef} // DOM 선택용 useRef
                initialValue="hello react editor world!"
                previewStyle='vertical'
                plugins={[colorSyntax, [codeSyntaxHighlight, { highlighter: Prism }]]}
                height="100vh"
                initialEditType="markdown"
                hideModeSwitch={true}
                toolbarItems={[]}
            />
            <button onClick={handleRegisterButton}>등록</button>
        </>
    );
}

export default Writer