
define(["IPC/javascript/ServiceManager", "IPC/gen/javascript/stub/TestA/TestAStub", "IPC/gen/javascript/stub/TestB/TestBStub"], function ()
{
    $.declareClass("IPC.StubTable", {
        static: {
            TestA_A: IPC.ServiceManager.registerService("TestA.A", new TestA.AStub()),
            TestB_B: IPC.ServiceManager.registerService("TestB.B", new TestB.BStub()),
        },
    });
});
