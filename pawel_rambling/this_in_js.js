// when example uses `this` in a function, use function syntax
function bla() {
    return this.something;
}

// when no this, then always use const
const anotherBla = () => {
    return "bla";
};

// wtf
function hello() {
    (() => {
        console.log(this.bla);
    })();
}

hello.bind({bla: 'hello!'})();